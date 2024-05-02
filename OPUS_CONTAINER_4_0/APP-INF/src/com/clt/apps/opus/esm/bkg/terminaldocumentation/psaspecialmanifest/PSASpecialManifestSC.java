/*=========================================================
 *Copyright(c)2014 CyberLogitec
 *@FileName : PSASpecialManifestSC.java
 *@FileTitle : PSASpecialManifestSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest;

import java.util.List;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0573Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0577Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0578Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.OpusBkgTPsacusAckEven;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASpecialContainerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-PSASpecialManifest Business Logic ServiceCommand -f
 * OPUS-PSASpecialManifest 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Kyoung Jong Yung
 * @see SpecialManifest
 * @since J2EE 1.4
 */

public class PSASpecialManifestSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PSASpecialManifest system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PSASpecialManifestSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e)throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0573Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPsaSendHistory(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0577Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPsaDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // Start Back End Job(TRANSMIT)
				eventResponse = startBackEndJobTransmitDgManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // Get status of Back End Job(공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {   // Result return(TRANSMIT)
				eventResponse = resultBackEndJobTransmitDgManifest(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0578Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPsaReceiveHistory(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("OpusBkgTPsacusAckEven")) {
			eventResponse = loadCstmsRcvMsg(e);
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
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();

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
	 * ESM_BKG_0573 :
	 * 송신 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaSendHistory(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		try {
			if ("EsmBkg0573Event".equalsIgnoreCase(e.getEventName())) {
				command = new PSASpecialManifestBCImpl();
				EsmBkg0573Event event = (EsmBkg0573Event)e;
				List<PSASendHistoryDetailVO> list = command.searchPsaSendHistory(event.getPsaSendHistoryCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0577 :
	 * 위험물 신고 대상 컨테이너를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaDgManifestList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0577Event event = (EsmBkg0577Event)e;
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();

		try {
			PSADgListCondVO psaDgListCondVO = event.getPsaDgListCondVO();
			eventResponse.setETCData("vsl_nm", command.searchPSAVslName(psaDgListCondVO.getVvdCd()));

			psaDgListCondVO.setOfcCd(account.getOfc_cd());
			List<PSADgListDetailVO> list = command.searchPsaDgManifestList(psaDgListCondVO);
			if (list != null && list.size() > 0) {
				PSASpecialContainerVO containerVO = (PSASpecialContainerVO)list.get(0);
				// 상단 배정보
				eventResponse.setRsVo(containerVO.getPsaVslInfo());
				// 하단 그리드 정보
				eventResponse.setRsVoList(containerVO.getPsaDetailList());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0577 : Transmit - Back End Job 시작<br>
	 * DG Cargo Flat File 생성 및 EDI Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitDgManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();
		EsmBkg0577Event event = (EsmBkg0577Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitDgManifest(event.getPsaDgEdiVOs(), account, "ESM_BKG_0577-Transmit");
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
	 * ESM_BKG_0577 : Transmit - Back End Job 결과<br>
	 * DG Cargo Flat File 생성 및 EDI Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitDgManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();
		EsmBkg0577Event event = (EsmBkg0577Event) e;

		try {
			begin();
			List<String> flatFileList = command.resultBackEndJobTransmitDgManifest(event.getAttribute("backEndJob_Key").toString());
			if (flatFileList != null && flatFileList.size() > 0) {
				eventResponse.setETCData("originalFlatFile", flatFileList.get(0));
				eventResponse.setETCData("updateFlatFile", flatFileList.get(1));
				eventResponse.setETCData("cancelFlatFile", flatFileList.get(2));
			} else {
				eventResponse.setETCData("originalFlatFile", "");
				eventResponse.setETCData("updateFlatFile", "");
				eventResponse.setETCData("cancelFlatFile", "");
			}
			
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0578 :
	 * PSA 수신 결과를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaReceiveHistory(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		try {
			if ("EsmBkg0578Event".equalsIgnoreCase(e.getEventName())) {
				command = new PSASpecialManifestBCImpl();
				EsmBkg0578Event event = (EsmBkg0578Event)e;
				List<PSASendHistoryDetailVO> list = command.searchPsaReceiveHistory(event.getPsaSendHistoryCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * OpusBkgTPsacusAckEven EDI수신<br>
	 *
	 * @param Event event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpusBkgTPsacusAckEven event = (OpusBkgTPsacusAckEven)e;
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();

		try {
			begin();
			command.loadCstmsRcvMsg(event.getFlatFile(), "OpusBkgTPsacusAckEven");
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

}
