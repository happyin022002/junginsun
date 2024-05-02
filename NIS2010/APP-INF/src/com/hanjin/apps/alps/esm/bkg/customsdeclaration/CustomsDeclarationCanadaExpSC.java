/*=========================================================
 *Copyright(c) 2017 SMLines 
 *@FileName : CustomsDeclarationCanadaExpSC.java
 *@FileTitle : CustomsDeclarationCanadaExpSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.01
 *@LastModifier : 
 *@LastVersion : 1.1
 *
 * 1.0 Creation
 *-------------------------------------------------------
 * History
=======================================================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndExpCustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndExpCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkgN002Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkgN003Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkgN005Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkgN006Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndExpManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndExpManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN001Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN004Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN007Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN008Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN009Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN010Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN011Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * NIS2010-CustomsDeclaration Business Logic ServiceCommand -
 * NIS2010-CustomsDeclaration 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationCanadaExpSC extends ServiceCommandSupport {
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
		log.debug("CustomsDeclarationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CustomsDeclarationCanadaExp system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("\n\n[SC.perform] Start ---------------------------");
		log.info("\n\n[SC.perform] e.getEventName() : " + e.getEventName());
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkgN001Event")) { //Canada Export : Customs Data Download
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD) || (e.getFormCommand().isCommand(FormCommand.MULTI))) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteManifest(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfListForTrans(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMfDtlListForTrans(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageMfListForTrans(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {            // Retrieve
				eventResponse = searchCstmsManifestAmendment(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {    // Transmit - Start AI
				eventResponse = transAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {    // Transmit -Immediate Delete & AI
				eventResponse = transDelAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {    // Save
				eventResponse = manageCstmsAmendManifest(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY) || e.getFormCommand().isCommand(FormCommand.MODIFY01)
					|| e.getFormCommand().isCommand(FormCommand.REMOVE) || e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02) || e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchHubInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchMdmCust(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCndCstmsSndHisList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvHisList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyContainerManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselDeparture(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = transmitVesselDeparture(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitActualVesselDeparture(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchMaxCndCstmsVvdRefNo(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsVvdInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCstmsCndVslCrnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeBkgCstmsCndVslCrnNo(e);
			}

		}

		log.info("\n\n[SC.perform] End ---------------------------");
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_N001 : SEARCH<BR>
	 *  - Canada Export : Customs Data Download 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN001Event event = (EsmBkgN001Event) e;

		try {
			eventResponse.setRsVoList(command.searchManifestList(event.getManifestListCondVO(), account));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_N001 : ADD/MULTI<BR>
	 *  - Canada Export : Customs Data Download 목록 등록/수정
	 *    (Back End Job 시작)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN001Event event = (EsmBkgN001Event) e;

		try {
			begin();
			eventResponse.setETCData("KEY", command.manageManifest(event.getManifestListDetailVOs(), account));
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
	 * [공통] : Back End Jot Result<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkgN001Event")) {
			EsmBkgN001Event event = (EsmBkgN001Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgN002Event")) {
			EsmBkgN002Event event = (EsmBkgN002Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkgN001Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";

				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkgN002Event")) {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_USR_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
					} else {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
						}
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
	 * ESM_BKG_N001 : MULTI05<BR>
	 *  - Canada Export : Customs Data Download 목록 삭제
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN001Event event = (EsmBkgN001Event) e;

		try {
			begin();
			command.deleteManifest(event.getManifestListDetailVOs());
			command.deleteManifestBl(event.getManifestListDetailVOs());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * [공통] : INIT <br>
	 * - com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String comCode
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
	 * [공통] : INIT <br>
	 * - HardCoding Table 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(String hrdCdgId) throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(hrdCdgId);
			return bkgUtil.searchHardCoding(hrdCdgVO);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_N002 : SEARCH<BR>
	 *  - Canada Export : Manifest Transmit 상단 헤더목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfListForTrans(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		EsmBkgN002Event event = (EsmBkgN002Event) e;

		try {
			eventResponse.setRsVoList(command.searchManifestList(event.getCstmsManifestCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N002 : SEARCH01<BR>
	 *  - Canada Export : Manifest Transmit 하단 상세목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfDtlListForTrans(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		EsmBkgN002Event event = (EsmBkgN002Event) e;

		try {
			eventResponse.setRsVoList(command.searchManifestDtlList(event.getCstmsManifestCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N002 : MULTI<br>
	 * ESM_BKG_N004 : MODIFY02<br>
	 *  - Canada Export : Manifest Transmit 목록 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();

		try {
			begin();

			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkgN002Event")) {
				EsmBkgN002Event event = (EsmBkgN002Event) e;
				event.getManifestTransmitVO().setPgmNo("ESM_BKG_N002");
				// BackEnd
				String key = command.transmitManifest(event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkgN004Event")) {
				EsmBkgN004Event event = (EsmBkgN004Event) e;
				String sFlatFile = new String();
				if (event.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					/***********************************************************
					 * BKG_CSTMS_ADV_BL 테이블 수정
					 ***********************************************************/
					CndCstmsBlMainVO cndCstmsBlMainVO = event.getCndCstmsBlMainVO();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("ESM_BKG_N004");
					cndManifestListDetailVO[0].setBlNo(cndCstmsBlMainVO.getBlNo());
					if ("D".equals(cndCstmsBlMainVO.getMfStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("03");
					} else if ("".equals(cndCstmsBlMainVO.getCstmsTrsmStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("00");
					} else {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("04");
					}
					// new CndExpManifestListDownloadBCImpl().manageManifest(cndManifestListDetailVO, account);    // 2016.08.23 중복호출로 인한 주석처리
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0].getEdiSndDt());
					sFlatFile = command.transmitManifest(cndCstmsManifestVO, account);    // 내부에서 command1.manageManifest() 호출

				} else if (event.getFormCommand().isCommand(FormCommand.MODIFY03)) {
					// 현재날짜를 가져오기 위해서
					CndExpManifestListDownloadBC command1 = new CndExpManifestListDownloadBCImpl();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("Terminal_Trans");
					command1.manageManifest(cndManifestListDetailVO, account);
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0].getEdiSndDt());
					cndCstmsManifestVO.setIbflag("Terminal");
					sFlatFile = command.transmitManifest(cndCstmsManifestVO, account);
				}
				/***********************************************************
				 * EDI transmitting START
				 ***********************************************************/
				if (sFlatFile != null) {
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(sFlatFile);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
					
					BookingUtil utilCommand = new BookingUtil();
					FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_N002 : MODIFY<BR>
	 *  - Canada Export : Manifest Transmit 목록 삭제
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfListForTrans(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN002Event event = (EsmBkgN002Event) e;

		try {
			begin();
			command.manageCstmsBl(event.getCstmsBlVOs(), account);
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
	 * ESM_BKG_N005 : SEARCH<BR>
	 * Transmit History 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCndCstmsSndHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		EsmBkgN005Event event = (EsmBkgN005Event) e;

		try {
			eventResponse.setRsVoList(command.searchCndCstmsSndHisList(event.getCndCstmsSndHisListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N006 : SEARCH<BR>
	 * Receive History<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		EsmBkgN006Event event = (EsmBkgN006Event) e;

		try {
			eventResponse.setRsVoList(command.searchCstmsRcvHisList(event.getCstmsRcvHisListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N003 : SEARCH<br>
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsManifestAmendment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		EsmBkgN003Event event = (EsmBkgN003Event) e;
		try {
			eventResponse.setRsVoList(command.searchCstmsManifestAmendment(event.getCstmsManifestAmendmentCondVO(), event.getAiDiv()));

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N003 : COMMAND01<BR>
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// CustomsTransmissionBC
		CndExpCustomsTransmissionBC command = new CndExpCustomsTransmissionBCImpl();
		// ManifestListDownloadBC
		CndExpManifestListDownloadBC command2 = new CndExpManifestListDownloadBCImpl();
		EsmBkgN003Event event = (EsmBkgN003Event) e;

		try {

			begin();

			// 파라메터
			CndCstmsManifestAmendmentVO cndVO = (CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();


			/*************************************************************
			 * Action Code에 따라 기능 수행
			 *************************************************************/
			for (int j=0; j<cndVO.getActionCode().length(); j = j + 2) {
				if ("DN".equals(cndVO.getActionCode().substring(j, j + 2))) {
					// Download의 경우 Customs Data Download 화면과 동일하기 때문에
					CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
					cndManifestModificationVOs[0] = new CndManifestModificationVO();
					cndManifestModificationVOs[0].setBkgNo   (cndVO.getBkgNo());
					cndManifestModificationVOs[0].setVslCd   (cndVO.getTVvdCd().substring(0, 4));
					cndManifestModificationVOs[0].setSkdVoyNo(cndVO.getTVvdCd().substring(4, 8));
					cndManifestModificationVOs[0].setSkdDirCd(cndVO.getTVvdCd().substring(8, 9));
					if (cndVO.getBVvdCd() == null || cndVO.getBVvdCd().equals("")) {
						cndManifestModificationVOs[0].setIfFlg("N");
					} else {
						cndManifestModificationVOs[0].setIfFlg("Y");
					}
					cndManifestModificationVOs[0].setBlType       (cndVO.getMh());
					cndManifestModificationVOs[0].setBlNos        (cndVO.getBlNo());
					cndManifestModificationVOs[0].setPgmNo        ("ESM_BKG_N003");
					cndManifestModificationVOs[0].setBkgPodCd     (cndVO.getBkgPodCd());
					cndManifestModificationVOs[0].setBkgDelCd     (cndVO.getBkgDelCd());
					cndManifestModificationVOs[0].setPodCd        (cndVO.getPodCd());
					cndManifestModificationVOs[0].setPolCd        (cndVO.getPolCd());
					cndManifestModificationVOs[0].setHubLocCd     (cndVO.getHubLocCd());
					cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
					command2.manageManifest(cndManifestModificationVOs, account);

				} else if ("DA".equals(cndVO.getActionCode().substring(j, j + 2))) {
					CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
					cndManifestModificationVOs[0] = new CndManifestModificationVO();
					cndManifestModificationVOs[0].setBlNo         (cndVO.getBlNo());
					cndManifestModificationVOs[0].setMfStsCd      ("D");
					cndManifestModificationVOs[0].setHubLocCd     (cndVO.getHubLocCd());
					cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
					command2.manageManifest(cndManifestModificationVOs, account);

				} else if ("RA".equals(cndVO.getActionCode().substring(j, j + 2))) {
					CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
					cndManifestModificationVOs[0] = new CndManifestModificationVO();
					cndManifestModificationVOs[0].setBlNo         (cndVO.getBlNo());
					cndManifestModificationVOs[0].setMfStsCd      ("A");
					cndManifestModificationVOs[0].setHubLocCd     (cndVO.getHubLocCd());
					cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
					command2.manageManifest(cndManifestModificationVOs, account);

				} else if ("AC".equals(cndVO.getActionCode().substring(j, j + 2)) || "DC".equals(cndVO.getActionCode().substring(j, j + 2))) {
					CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
					cndManifestModificationVOs[0] = new CndManifestModificationVO();
					cndManifestModificationVOs[0].setBlNo(cndVO.getBlNo());

					/***********************************************************
					 * A6A:Manifest, S10:HB/L Manifest, E10:Empty B/L
					 **********************************************************/
					if ("M".equals(cndVO.getMh())) {
						cndManifestModificationVOs[0].setCstmsMfTpCd("A6A");
						if ("M".equals(cndVO.getFullMtyCd())) {
							cndManifestModificationVOs[0].setCstmsMfTpCd("E10");
						}
					} else {
						cndManifestModificationVOs[0].setCstmsMfTpCd("S10");
					}
					/***********************************************************
					 * 00:최초전송, 04:수정전송, 03:Cancel 전송
					 **********************************************************/
					if ("DC".equals(cndVO.getActionCode().substring(j, j + 2))) {
						cndManifestModificationVOs[0].setCstmsTrsmStsCd("03");
					} else {
						if ("".equals(cndVO.getCstmsTrsmStsCd())) {
							cndManifestModificationVOs[0].setCstmsTrsmStsCd("00");
						} else {
							cndManifestModificationVOs[0].setCstmsTrsmStsCd("04");
						}
					}
					cndManifestModificationVOs[0].setHubLocCd     (cndVO.getHubLocCd());
					cndManifestModificationVOs[0].setIbdLocGdsDesc(cndVO.getIbdLocGdsDesc());
					command2.manageManifest(cndManifestModificationVOs, account);
					/***********************************************************
					 * 전송 FlatFile 만들어서 로그테이블에 등록
					 **********************************************************/
					cndVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());
					command.transAmendManifest(cndVO, account);
				}
			}
			/*************************************************************
			 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다.<br>
			 * AI 성공하면 BL No.를 세팅해서 화면으로 전달하고 같은 BL No.의 경우 체크를 해제하고<br>
			 * 다음 BL No.에 대한 AI를 시작한다.
			 *************************************************************/
			CndCstmsManifestAmendmentVO vo = new CndCstmsManifestAmendmentVO();
			vo.setBlNo(((CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO()).getBlNo());
			List<CndCstmsManifestAmendmentVO> listOkBlNo = new ArrayList<CndCstmsManifestAmendmentVO>();
			listOkBlNo.add(vo);
			eventResponse.setRsVoList(listOkBlNo);

			commit();

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N003 : COMMAND02<BR>
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transDelAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkgN003Event event = (EsmBkgN003Event) e;
		String strBlNo = "";

		try {

			begin();

			CndCstmsManifestAmendmentVO cndCstmsManifestAmendmentVO = (CndCstmsManifestAmendmentVO) event.getCstmsManifestAmendmentVO();
			CndExpManifestListDownloadBC manifastCommand = new CndExpManifestListDownloadBCImpl();
			CndExpCustomsTransmissionBC tranmitCommand = new CndExpCustomsTransmissionBCImpl();

			strBlNo = cndCstmsManifestAmendmentVO.getBlNo();

			/* 불필요해 보임.
			//BKG_CSTMS_ADV_BL 테이블 수정 : ADV_BL delete
			CstmsBlVO[] cstmsBlVOs = new CstmsBlVO[1];
			CndCstmsBlVO cndCstmsBlVOs = new CndCstmsBlVO();
			cndCstmsBlVOs.setPgmNo("ESM_BKG_N002");//Canada Export: Manifest Transmit 이용 - 상태 코드 저장
			cndCstmsBlVOs.setBlNo(strBlNo);
			cndCstmsBlVOs.setMfStsCd("D");         //상태 코드 저장
			cstmsBlVOs[0] = cndCstmsBlVOs;
			manifastCommand.manageCstmsBl(cstmsBlVOs, account);
			 */
			//03:Cancel
			ManifestListDetailVO[] manifestListDetailVOs = new ManifestListDetailVO[1];
			CndManifestModificationVO cndManifestModificationVO = new CndManifestModificationVO();
			cndManifestModificationVO.setBlNo(strBlNo);
			cndManifestModificationVO.setMfStsCd("D");
			cndManifestModificationVO.setCstmsTrsmStsCd("03");
			cndManifestModificationVO.setPgmNo("ESM_BKG_N004");//Canada Export: Manifest Details By B/L 이용
			manifestListDetailVOs[0] = cndManifestModificationVO;
			manifastCommand.manageManifest(manifestListDetailVOs, account);
			CndManifestModificationVO cndVoX = (CndManifestModificationVO) manifestListDetailVOs[0];

			 //삭제전송
			CndCstmsManifestVO cndCstmsManifestVO = new CndCstmsManifestVO();
			cndCstmsManifestVO.setBlNo(strBlNo);
			cndCstmsManifestVO.setMiSndDt(cndVoX.getEdiSndDt());
			cndCstmsManifestVO.setIbflag("R");
			tranmitCommand.transmitManifest(cndCstmsManifestVO, account);

			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException((String) new ErrorHandler("BKG40110",new String[] {"(BL:"+strBlNo+")"}).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N003 : Save<br>
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 수정 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN003Event event =(EsmBkgN003Event) e;

		try {
			begin();
			command.manageCstmsAmendManifest(event.getCstmsManifestAmendmentVOs(), account, event.getCntCd(), event.getAiDiv());
			commit();
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
	 * ESM_BKG_N004 : INIT<br>
	 * - ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm Indicator를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// WGT 단위콤보
			eventResponse.setRsVoList(searchComCodeCombo("CD00775"));
			// trsp_tp_id 콤보
			eventResponse.setRsVoList(searchHardCoding("TRSPT_TP_ID_EXP"));
			// 개발자 User Id 조회(Stage 수정권한)
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.SCR_ROLE_DEF);
			hrdCdgVO.setAttrCtnt1("CND_CSTMS_BL_INQ_STS_UPD");
			hrdCdgVO.setAttrCtnt2("USR_ID");
			hrdCdgVO.setAttrCtnt3(account.getUsr_id());
			hrdCdgVO.setAttrCtnt4("Y");
			eventResponse.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N004 : SEARCH<BR>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();;
		EsmBkgN004Event event = (EsmBkgN004Event) e;

		try {
			List<BlDetailVO> list = command.inquiryBlData(event.getCndCstmsBlCondVO());
			if (list.size() > 0) {
				CndBlDetailVO vo = (CndBlDetailVO) list.get(0);
				eventResponse.setRsVo(vo.getCndCstmsBlMainVO());
				eventResponse.setRsVo(vo.getCndCstmsBlCustVO());
				eventResponse.setRsVoList(vo.getCndCstmsBlCstmsRsltVOs());
				eventResponse.setRsVoList(vo.getCndCstmsBlHblListVOs());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N004 : MULTI <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN004Event event = (EsmBkgN004Event) e;

		try {
			begin();

			String msgCd = "BKG00166";
			if (e.getFormCommand().isCommand(FormCommand.REMOVE) || e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				/*************************************************
				 * ESM_BKG_0002 : MF_STS_CD 수정 ESM_BKG_N004 : MF_STS_CD, CSTMS_TRSM_STS_CD 수정
				 *************************************************/
				event.getCstmsBlVOs()[0].setPgmNo("ESM_BKG_N002");
				if ("D".equals(((CndCstmsBlVO) (event.getCstmsBlVOs()[0])).getMfStsCd())) {
					msgCd = "BKG00593";
				}
			}
			// 수정
			command.manageCstmsBl(event.getCstmsBlVOs(), account);
			// 저장성공메시지
			eventResponse.setUserMessage(new ErrorHandler(msgCd).getUserMessage());

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
	 * ESM_BKG_N004 : SEARCH01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgReferenceNumberGeneration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();

		try {
			begin();

			BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = utilBC.manageBkgReferenceNumberGeneration("CAD", account.getOfc_cd(), account.getUsr_id());
			eventResponse.setETCData("dummy_bl_no", bkgReferenceNoGenerationVO.getCadNo());

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
	 * ESM_BKG_N004 : SEARCH01<br>
	 * - DEL_CD 입력후 HUB, Location of Goods조회
	 *
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchHubInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN004Event event = (EsmBkgN004Event) e;

		try {
			String[] arrHubInfo = command.searchHubInfo(event.getPodCd(), event.getDelCd(), event.getPodNodCd());
			eventResponse.setETCData("hub_loc_cd", arrHubInfo[0]);
			eventResponse.setETCData("ibd_loc_gds_desc", arrHubInfo[1]);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N004 : SEARCH01<br>
	 * - DEL_CD 입력후 HUB, Location of Goods조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();
		EsmBkgN004Event event = (EsmBkgN004Event) e;

		try {
			if ("D".equals(event.getCustTp())) {
				// Delivery의 경우 Yard 와 Location정보
				MdmYardVO mdmYardVO = new MdmYardVO();
				mdmYardVO.setYdCd(event.getCustCntCd() + event.getCustSeq());
				List<MdmYardVO> listYard = utilBC.searchYardCode(mdmYardVO);
				if (listYard.size() > 0) {
					eventResponse.setETCData("cust_nm", listYard.get(0).getYdNm());
					eventResponse.setETCData("cust_addr", listYard.get(0).getYdAddr());
					SearchLocationCodeVO locVO = utilBC.searchLocationCode(listYard.get(0).getLocCd());
					if (locVO != null) {
						eventResponse.setETCData("loc_nm", locVO.getLocNm());
						eventResponse.setETCData("ste_cd", locVO.getSteCd());
						eventResponse.setETCData("cnt_cd", locVO.getCntCd());
						eventResponse.setETCData("zip_cd", listYard.get(0).getZipCd());
					}
				} else {
					throw new EventException(new ErrorHandler("BKG00651", new String[] { "Location or Node code" }).getMessage());
				}
			} else {
				MdmCustVO mdmCustVO = utilBC.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
				if (mdmCustVO != null) {
					eventResponse.setETCData("cust_nm", mdmCustVO.getName());
					eventResponse.setETCData("cust_addr", mdmCustVO.getAddress());
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
	 * ESM_BKG_N007 : SEARCH<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN007Event event = (EsmBkgN007Event) e;

		try {
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

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1573 : MULTI<BR>
	 * Container 정보를 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN007Event event = (EsmBkgN007Event) e;

		try {
			begin();
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
	 * ESM_BKG_N008 : SEARCH<BR>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN008Event event = (EsmBkgN008Event) e;

		try {
			UsaContainerManifestDetailVO detailVO = (UsaContainerManifestDetailVO) command.searchContainerManifest(event.getContainerManifestCondVO());
			eventResponse.setRsVoList(detailVO.getUsaContainerListVOs());
			eventResponse.setRsVoList(detailVO.getUsaCntrManifestListVOs());
			eventResponse.setRsVoList(detailVO.getUsaCntrManifestInfoVOs());
			if (detailVO.getUsaCntrManifestInfoVOs().size() > 0) {
				eventResponse.setETCData(detailVO.getUsaCntrManifestInfoVOs().get(0).getColumnValues());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_N008 : MODIFY<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN008Event event = (EsmBkgN008Event) e;

		try {
			begin();
			command.modifyContainerManifest(event.getContainerManifestListVOs(), account);
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
	 * ESM_BKG_N009 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselDeparture(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = null;
		try {
			EsmBkgN009Event event = (EsmBkgN009Event) e;
			command = new CndExpManifestListDownloadBCImpl();
			eventResponse.setRsVoList(command.searchVesselDeparture(event.getVesselArrivalCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}



	/**
	 * ESM_BKG_N009 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		CndExpManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkgN009Event event = (EsmBkgN009Event) e;
			command = new CndExpManifestListDownloadBCImpl();
			command.manageVesselArrival(event.getVeseelArrivalVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_BKG_N009 : ADD <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselDeparture(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			EsmBkgN009Event event = (EsmBkgN009Event) e;
			command = new CndExpCustomsTransmissionBCImpl();
			CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event.getVesselArrivalTransmitVO();
			/***********************************************************
			 * VesselArrival에 send date 수정
			 ***********************************************************/
			CndExpManifestListDownloadBC vslBC = new CndExpManifestListDownloadBCImpl();
			CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
			vslVO.setVslCd(vo.getVslCd());
			vslVO.setSkdVoyNo(vo.getSkdVoyNo());
			vslVO.setSkdDirCd(vo.getSkdDirCd());
			vslVO.setVpsPortCd(vo.getPolCd());
			vslVO.setCapNm(vo.getCapNm());
			vslVO.setVpsEtaDt(vo.getVpsEtaDt());
			// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
			// manageVesselArrival안에서 함
			vslBC.manageVesselArrival(vslVO, account);
			/***********************************************************
			 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
			 ***********************************************************/
			vo.setVslDepRptSndDt(vslVO.getVslDepRptSndDt());
			String sFlatFile = command.transmitVesselDeparture(vo, account);
			/***********************************************************
			 * EDI 전송 START
			 ***********************************************************/
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(sFlatFile);
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
			BookingUtil utilCommand = new BookingUtil();
			FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")){
				throw new EventException(new ErrorHandler("BKG00205",new String[] {}).getMessage());
			}
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_N009 : MULTI01 <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitActualVesselDeparture(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkgN009Event event = (EsmBkgN009Event) e;
			command = new CndExpCustomsTransmissionBCImpl();
			CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event.getVesselArrivalTransmitVO();
			/***********************************************************
			 * VesselArrival에 send date 수정
			 ***********************************************************/
			CndExpManifestListDownloadBC vslBC = new CndExpManifestListDownloadBCImpl();
			CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
			vslVO.setVslCd(vo.getVslCd());
			vslVO.setSkdVoyNo(vo.getSkdVoyNo());
			vslVO.setSkdDirCd(vo.getSkdDirCd());
			vslVO.setVpsPortCd(vo.getPolCd());
			vslVO.setCapNm(vo.getCapNm());
			vslVO.setActDepDt(vo.getActDepDt());
			// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
			// manageVesselArrival안에서 함
			vslBC.manageVesselArrival(vslVO, account);
			/***********************************************************
			 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
			 ***********************************************************/
			vo.setVslDepRptSndDt(vslVO.getVslDepRptSndDt());
			String sFlatFile = command.transmitActualVesselDeparture(vo,account);
			/***********************************************************
			 * EDI 전송 START
			 ***********************************************************/
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(sFlatFile);
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
			BookingUtil utilCommand = new BookingUtil();
			FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205",new String[] {}).getMessage());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_N010 : SEARCH <br>
	 * 
	 * Container Manifest 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
		EsmBkgN010Event event = (EsmBkgN010Event)e;

		try {
			List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event.getCstmsVvdInfoCondVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

		/**
		 * ESM_BKG_N010 : MULTI <br>
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse manageCstmsVvdInfo(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
			EsmBkgN010Event event = (EsmBkgN010Event)e;

			ManifestListDownloadBC       commandImport = null;
			try {
				begin();
				command.manageCstmsVvdInfo(event.getCstmsVvdInfoVOS(), account);
				
				if("IE".equals(event.getIeTypeCd())){
					//@ Import CRN No. 생성
					commandImport = new CndManifestListDownloadBCImpl();
					commandImport.manageCstmsVvdInfo(event.getCstmsVvdInfoVOS(), account);
					
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
		 * ESM_BKG_N010 : SEARCH11<BR>
		 * 세관 신고용 VVD별 Reference No 조회<br>
		 * 
		 * @param Event
		 *            e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchMaxCndCstmsVvdRefNo(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
			try {
				// 이벤트별 Impl생성
				EsmBkgN010Event event = (EsmBkgN010Event) e;
				eventResponse.setETCData("max_cvy_ref_no", command.searchMaxCndCstmsVvdRefNo(event.getCstmsVvdRefNoCondVO()).getNewCrn());
				return eventResponse;
			} catch (EventException ex) {
				throw ex;
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06086").getMessage(),
						ex);
			}
		}

		/**
		 * ESM_BKG_N011 : IBSEARCH <br>
		 * CRN 조회한다.<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchBkgCstmsCndVslCrnNo(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			CndExpManifestListDownloadBC command = null;
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			try {
				EsmBkgN011Event event = (EsmBkgN011Event) e;
				command = new CndExpManifestListDownloadBCImpl();
				List<CndCstmsVslCrnNoVO> cndCstmsVslCrnNoVO = command.searchBkgCstmsCndVslCrnNo((CndCstmsVslCrnNoVO) event.getCndCstmsVslCrnNoVO());
			    if (cndCstmsVslCrnNoVO.size() == 0){
			    	eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			    }
			    
		    	eventResponse.setRsVoList(cndCstmsVslCrnNoVO);

			} catch (EventException ex) {
				throw ex;
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06086").getMessage(),
				ex);
			}
			return eventResponse;
		}
		
		/**
		 * EsmBkgN011Event management event process<br>
		 *  CRN 정보삭제<br>
		 * @param Event
		 * @return EventResponse
		 * @exception EventException
	 	 */
	    private EventResponse removeBkgCstmsCndVslCrnNo(Event e) throws EventException {
	    	EsmBkgN011Event event = (EsmBkgN011Event) e;
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    	CndExpManifestListDownloadBC command = new CndExpManifestListDownloadBCImpl();
	    	
	        try {
	            begin();
	                        
	            command.removeBkgCstmsCndVslCrnNo(event.getCndCstmsVslCrnNoVO());
	            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
	            
	            commit();
	             
	        } catch(EventException ex) {
	 			rollback();
	 			throw ex;
	 		} catch(Exception ex) {
	 			rollback();
	 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	 		}
	        return eventResponse;
	    } 		
		
}// end class
