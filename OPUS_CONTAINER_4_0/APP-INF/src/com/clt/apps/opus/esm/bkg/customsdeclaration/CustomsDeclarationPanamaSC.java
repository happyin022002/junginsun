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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.basic.PanamaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.basic.PanamaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.EsmBkg1193Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.EsmBkg1194Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.OpusbkgPanamaReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaCstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0016Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.basic.PanamaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.basic.PanamaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0017Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0018Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclarationPanamaSC Business Logic ServiceCommand - OPUS-CustomsDeclarationPanamaSC handling business transaction.
 * 
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationPanamaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationPanamaSC system <br>
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
	 * CustomsDeclarationPanamaSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationPanamaSC 종료");
	}

	/**
	 * 
	 * OPUS-CustomsDeclarationPanamaSC system <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event") || e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchCstmsCdConvCtntList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusbkgPanamaReceiveEvent")) {
			loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1193Event") || e.getEventName().equalsIgnoreCase("EsmBkg1194Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Retrieve
				eventResponse = searchCstmsRcvLog(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PanamaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
				EsmBkg0017Event event = (EsmBkg0017Event) e;
				List<PanamaContainerVO> panamaContainerVOs = null;
				PanamaContainerVO panamaContainerVO = null;
				command = new PanamaManifestListDownloadBCImpl();
				panamaContainerVOs = (List<PanamaContainerVO>) (Object) (command.searchManifestList((ManifestListCondVO) event
						.getPanamaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				if (panamaContainerVOs.size() > 0) {
					panamaContainerVO = panamaContainerVOs.get(0);
					PanamaVesselVO panamaVesselVO = panamaContainerVO.getPanamaVesselVO();
					eventResponse.setETCData("slan_cd", panamaVesselVO.getSlanCd());
					eventResponse.setETCData("pod_cd", panamaVesselVO.getPodCd());
					eventResponse.setETCData("pol_cd", panamaVesselVO.getPolCd());
					eventResponse.setETCData("vps_eta_dt", panamaVesselVO.getVpsEtaDt());
					eventResponse.setETCData("shp_id_no", panamaVesselVO.getShpIdNo());
					eventResponse.setETCData("vst_no", panamaVesselVO.getVstNo());
					eventResponse.setETCData("mvmt_seq", panamaVesselVO.getMvmtSeq());
					eventResponse.setETCData("pnm_org_cd", panamaVesselVO.getPnmOrgCd());
					eventResponse.setETCData("pnm_vsl_opr_cd", panamaVesselVO.getPnmVslOprCd());
					eventResponse.setETCData("pnm_dest_cd", panamaVesselVO.getPnmDestCd());
					eventResponse.setETCData("edi_snd_dt", panamaVesselVO.getEdiSndDt());
					eventResponse.setETCData("edi_snd_seq", panamaVesselVO.getEdiSndSeq());
					List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListGeneralCargoDetailVOs();
					eventResponse.setRsVoList(panamaManifestListGeneralCargoDetailVOs);
					List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListEmptyCargoDetailVOs();
					eventResponse.setRsVoList(panamaManifestListEmptyCargoDetailVOs);
					List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardousCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListHazardCargoDetailVOs();
					eventResponse.setRsVoList(panamaManifestListHazardousCargoDetailVOs);
				} else {
					eventResponse.setETCData("slan_cd", "");
					eventResponse.setETCData("pod_cd", "");
					eventResponse.setETCData("pol_cd", "");
					eventResponse.setETCData("vps_eta_dt", "");
					eventResponse.setETCData("shp_id_no", "");
					eventResponse.setETCData("vst_no", "");
					eventResponse.setETCData("mvmt_seq", "");
					eventResponse.setETCData("pnm_org_cd", "");
					eventResponse.setETCData("pnm_vsl_opr_cd", "");
					eventResponse.setETCData("pnm_dest_cd", "");
					eventResponse.setETCData("edi_snd_dt", "");
					eventResponse.setETCData("edi_snd_seq", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
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
	 * ESM_BKG_0462 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PanamaCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
				EsmBkg0017Event event = (EsmBkg0017Event) e;
				command = new PanamaCustomsTransmissionBCImpl();

				String key = command.startBackEndJob(account, event.getManifestTransmitVO(), "ESM_BKG_0017");
				eventResponse.setETCData("KEY", key);
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
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
			EsmBkg0017Event event = (EsmBkg0017Event) e;
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
					if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
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
	private EventResponse searchVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PanamaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event")) {
				EsmBkg0018Event event = (EsmBkg0018Event) e;
				command = new PanamaManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event.getPanamaVesselCondVO());
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
	 * ESM_BKG_0249 : SEARCH<BR>
	 * ESM_BKG_0551 : SEARCH<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 * 
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event")) {
				EsmBkg0018Event event = (EsmBkg0018Event) e;
				PanamaManifestListDownloadBC command = new PanamaManifestListDownloadBCImpl();
				command.manageVessel(event.getPanamaVesselVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
				EsmBkg0016Event event = (EsmBkg0016Event) e;
				CndManifestListDownloadBC command = new CndManifestListDownloadBCImpl();
				command.manageCstmsVesselInfo(event.getVesselInfoVOs(), account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
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
	 * 수신
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			OpusbkgPanamaReceiveEvent event = (OpusbkgPanamaReceiveEvent) e;
			PanamaCustomsTransmissionBC command = new PanamaCustomsTransmissionBCImpl();
			command.loadCstmsRcvMsg(event.getFlatFile());
			commit();
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException("loadCstmsRcvMsg", ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

	/**
	 * searchCstmsRcvLog <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvLog(Event e) throws EventException {

		PanamaCustomsTransmissionBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1193Event")) {
				EsmBkg1193Event event = (EsmBkg1193Event) e;
				command = new PanamaCustomsTransmissionBCImpl();
				BkgCstmsPnmRcvLogVO condVO = event.getBkgCstmsPnmRcvLogVO();
				List<PanamaCstmsRcvLogVO> bkgCstmsPnmRcvLogVOs = command.searchCstmsRcvLogList(condVO);
				eventResponse.setRsVoList(bkgCstmsPnmRcvLogVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1194Event")) {
				EsmBkg1194Event event = (EsmBkg1194Event) e;
				command = new PanamaCustomsTransmissionBCImpl();
				BkgCstmsPnmRcvLogVO condVO = event.getBkgCstmsPnmRcvLogVO();
				List<BkgCstmsPnmRcvLogVO> bkgCstmsPnmRcvLogVOs = command.searchCstmsRcvLogDetail(condVO);
				eventResponse.setRsVoList(bkgCstmsPnmRcvLogVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * searchCstmsCdConvCtntList
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvCtntList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CustomsCommonMgtBCImpl command = new CustomsCommonMgtBCImpl();
			CstmsCdConvVO conVO = new CstmsCdConvVO();
			conVO.setChkCntCd("PA");
			conVO.setChkCstmsDivId("VSL_OPERATER");
			conVO.setOrderByCol("ATTR_CTNT3");
			List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(conVO);
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
}// end class
