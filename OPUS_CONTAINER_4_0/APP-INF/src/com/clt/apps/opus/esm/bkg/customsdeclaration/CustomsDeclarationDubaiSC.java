/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationDubaiSC.java
*@FileTitle : CustomsDeclarationDubaiSC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.basic.DubaiCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.basic.DubaiCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic.DubaiManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic.DubaiManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1085Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1086Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1087Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiBlManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiVesselManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;


/**
 * OPUS-CustomsDeclarationDubai Business Logic ServiceCommand<br>
 * - Process the business transactions for the OPUS-CustomsDeclarationDubai.
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class CustomsDeclarationDubaiSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationDubaiSC system <br>
	 * ESM_BKG_1085<br>
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
	 * CustomsDeclarationDubaiSC system <br>
	 * ESM_BKG_1085 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationDubaiSC 종료");
	}

	/**
	 *
	 * CustomsDeclarationDubaiSC system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// DUBAI TRADE CODE
				response.setRsVoList(searchCodeCombo("CD02558"));
				// DUBAI CARGO CODE
				response.setRsVoList(searchCodeCombo("CD02559"));

				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) || e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPkgUnitList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkgUnitList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePkgUnit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsBl(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_1085 : INIT <br>
	 * 코드별 콤보 데이터 조회<br>
	 *
	 * @param String comCode
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
	 * ESM_BKG_1085 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DubaiManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg1085Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				List<ManifestListDetailVO> manifestListDetailVOs = command.searchManifestList(event.getManifestListCondVO());
				if (manifestListDetailVOs.size() > 0) {
					DubaiManifestListVO dubaiManifestListVO = (DubaiManifestListVO) manifestListDetailVOs.get(0);
					eventResponse.setRsVoList(dubaiManifestListVO.getDubaiBlManifestListVOs());
					eventResponse.setRsVoList(dubaiManifestListVO.getDubaiCntrManifestListVOs());
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
	 * ESM_BKG_1085 : MULTI01 <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DubaiManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestListDetailVOs(), account);
				commit();
				begin();
				// Inbound 호출
				CargoReleaseOrderBC ibCommand = new CargoReleaseOrderBCImpl();
				DubaiManifestListVO[] dubaiManifestListVOs = (DubaiManifestListVO[]) event.getManifestListDetailVOs();
				List<DubaiBlManifestListVO> dubaiBlManifestListVOs = dubaiManifestListVOs[0].getDubaiBlManifestListVOs();
				DubaiManifestListCondVO dubaiManifestListCondVO = dubaiManifestListVOs[0].getDubaiManifestListCondVO();
				DubaiCstmsVO[] dubaiCstmsVOs = new DubaiCstmsVO[dubaiBlManifestListVOs.size()];
				for (int i = 0; i < dubaiBlManifestListVOs.size(); i++) {
					dubaiCstmsVOs[i] = new DubaiCstmsVO();
					dubaiCstmsVOs[i].setBlNo(dubaiBlManifestListVOs.get(i).getBlNo());
					dubaiCstmsVOs[i].setCstmsRefCtnt(dubaiManifestListCondVO.getRotnNo());
					dubaiCstmsVOs[i].setUsrId(account.getUsr_id());
				}
				ibCommand.modifyDubaiCstmsRefNo(dubaiCstmsVOs);
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
	 *
	 * ESM_BKG_1085 : COMMAND01 <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DubaiCustomsTransmissionBC command = null;
		String flatFile = "";
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				// 두바이 Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				// update
				DubaiManifestTransmitVO[] dubaiManifestTransmitVOs = (DubaiManifestTransmitVO[]) event.getManifestTransmitVOs();
				DubaiVesselManifestListVO[] vos = new DubaiVesselManifestListVO[1];
				vos[0] = new DubaiVesselManifestListVO();
				vos[0].setVslCd(dubaiManifestTransmitVOs[0].getVslCd());
				vos[0].setSkdVoyNo(dubaiManifestTransmitVOs[0].getSkdVoyNo());
				vos[0].setSkdDirCd(dubaiManifestTransmitVOs[0].getSkdDirCd());
				vos[0].setPodCd(dubaiManifestTransmitVOs[0].getPodCd());
				vos[0].setClptSeq(dubaiManifestTransmitVOs[0].getClptSeq());
				DubaiManifestListDownloadBC downCommand = new DubaiManifestListDownloadBCImpl();
				downCommand.manageCstmsVvdInfo(vos, account);
				// transmit
				command = new DubaiCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(event.getManifestTransmitVOs(), account);
				StringTokenizer st = new StringTokenizer(flatFile, "\n");
				List<DubaiManifestTransmitVO> list = new ArrayList<DubaiManifestTransmitVO>();
				int j = st.countTokens();
				for (int i = 0; i < j; i++) {
					DubaiManifestTransmitVO vo = new DubaiManifestTransmitVO();
					vo.setFlatFile(st.nextToken());
					list.add(vo);
				}
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_1085 : INIT<br>
	 * Advice Notes Type 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkgUnitList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DubaiManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				List<BkgCstmsCdConvCtntVO> list = command.searchPkgUnitList(event.getBkgCstmsCdConvCtntVO());
				if (list.size() == 0)
					eventResponse.setETCData("du_pck_tp_cd", "");
				else
					eventResponse.setETCData("du_pck_tp_cd", "true");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 국가별 Package Unit 관리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePkgUnit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1086Event event = (EsmBkg1086Event) e;
			CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
			command.manageCdConvCtnt(event.getBkgCstmsCdConvCtntVOs(), account);
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
	 * CDL 자동전송
	 *
	 * @param blNo
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DubaiManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1087Event event = (EsmBkg1087Event) e;
			command = new DubaiManifestListDownloadBCImpl();
			eventResponse.setRsVo(command.searchManifestInfo(event.getManifestListCondVO()));

			// DUBAI TRADE CODE
			eventResponse.setRsVoList(searchCodeCombo("CD02558"));
			// DUBAI CARGO CODE
			eventResponse.setRsVoList(searchCodeCombo("CD02559"));
			// DUBAI CONTAINER SERVICE TYPE CODE
			eventResponse.setRsVoList(searchCodeCombo("CD02560"));
			// DUBAI TRANSSHIPMENT MODE CODE
			eventResponse.setRsVoList(searchCodeCombo("CD02564"));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1087 : MULTI <br>
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해
	 * 사전 VVD INFORMATION을 입력한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DubaiManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg1087Event event = (EsmBkg1087Event) e;
			command = new DubaiManifestListDownloadBCImpl();
			command.manageCstmsBl(event.getCstmsBlVOs(), account);
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
}
